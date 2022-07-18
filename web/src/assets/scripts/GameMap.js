import { AcGameObject } from "@/assets/scripts/AcGameObjects";
import {Wall} from "@/assets/scripts/Wall";

export class GameMap extends AcGameObject{
    constructor(ctx, parent) {
        super();

        this.ctx = ctx;
        this.parent = parent;
        this.L = 0;

        //行数和列数
        this.rows = 13;
        this.cols = 13;

        //墙
        this.inner_walls_count = 20;
        this.walls = [];


    }

    //检测两个点的连通性
    check_connectivity(g, sx, sy, tx, ty) {
        if (sx === tx && sy === ty) return true;
        g[sx][sy] = true;

        let dx = [-1, 0, 1, 0], dy = [0, 1, 0, -1];
        for (let i = 0; i < 4; i ++ ) {
            let x = sx + dx[i], y = sy + dy[i];
            if (!g[x][y] && this.check_connectivity(g, x, y, tx, ty))
                return true;
        }

        return false;
    }


    create_walls(){
        const g = [];
        //有无墙，初始全无
        for (let r = 0; r < this.rows; r ++ ) {
            g[r] = [];
            for (let c = 0; c < this.cols; c ++ ) {
                g[r][c] = false;
            }
        }

        // 给四周加上障碍物
        for (let r = 0; r < this.rows; r ++ ) {
            g[r][0] = g[r][this.cols - 1] = true;
        }
        for (let c = 0; c < this.cols; c ++ ) {
            g[0][c] = g[this.rows - 1][c] = true;
        }

        //随机生成障碍物

        for (let i = 0; i < this.inner_walls_count; i++) {
            for (let j = 0; j < 1000; j++) {
                let r = parseInt(Math.random() * this.rows);
                let c = parseInt(Math.random() * this.cols);
                if(g[r][c] || g[c][r]) continue;
                if(r === this.rows - 2 && c === 1 || r === 1 && c === this.cols - 2) continue;
                g[r][c] = g[c][r] = true;
                break;
            }
        }

        //利用序列化深拷贝数组g
        const copy_g = JSON.parse(JSON.stringify(g));
        //检测连通性
        if (!this.check_connectivity(copy_g, this.rows - 2, 1, 1, this.cols - 2))
            return false;


        for (let i = 0; i < this.rows; i++) {
            for (let j = 0; j < this.cols; j++) {
                if(g[i][j] === true)
                    this.walls.push(new Wall(i, j, this));

            }

        }

        return true;


    }

    start() {
        for (let i = 0; i < 1000; i ++ )
            if (this.create_walls())
                break;

    }


    //根基canvas的大小更新长宽
    update_size() {
        this.L = parseInt(Math.min(this.parent.clientWidth / this.cols, this.parent.clientHeight / this.rows));
        this.ctx.canvas.width = this.L * this.cols;
        this.ctx.canvas.height = this.L * this.rows;
    }


    update() {
        this.update_size();
        this.render();
    }

    render() {
        /*颜色*/
        const color_even = "#AAD751", color_odd = "#A2D149";
        //枚举格子
        for (let r = 0; r < this.rows; r ++ ) {
            for (let c = 0; c < this.cols; c ++ ) {
                if ((r + c) % 2 === 0) {
                    this.ctx.fillStyle = color_even;
                } else {
                    this.ctx.fillStyle = color_odd;
                }
                //绘制深浅相间的地图背景
                this.ctx.fillRect(c * this.L, r * this.L, this.L, this.L);
            }
        }

        //canvas坐标系，横x竖y



    }
}
