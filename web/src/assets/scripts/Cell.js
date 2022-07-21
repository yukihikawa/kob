export class Cell{
    constructor(r, c) {
        this.r = r;
        this.c = c;
        //中心点坐标
        this.x = c + 0.5;
        this.y = r + 0.5;
    }
}
