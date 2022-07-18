const AC_GAME_OBJECTS = [];

export class AcGameObject { //可被引用的类
    constructor() {  //构造
        AC_GAME_OBJECTS.push(this);
        this.timedelta = 0; //这帧与上一帧的时间间隔
        this.has_called_start = false; //是否执行过
    }

    start() {  // 只执行一次

    }

    update() {  // 每一帧执行一次，除了第一帧之外

    }

    on_destroy() {  // 删除之前执行

    }

    destroy() {
        this.on_destroy();
        //销毁时把自己从AC_GAME_OBJECT中删掉
        for (let i in AC_GAME_OBJECTS) {
            const obj = AC_GAME_OBJECTS[i];
            if (obj === this) {
                AC_GAME_OBJECTS.splice(i); //删除数组重的元素
                break;
            }
        }
    }
}

let last_timestamp;  // 上一次执行的时刻


const step = timestamp => { //传入当前执行的时刻
    for (let obj of AC_GAME_OBJECTS) { //遍历，of遍历值
        if (!obj.has_called_start) {  //没执行start的执行一次
            obj.has_called_start = true;
            obj.start();
        } else {
            obj.timedelta = timestamp - last_timestamp;
            obj.update();
        }
    }

    last_timestamp = timestamp; //更新时间标志
    requestAnimationFrame(step)  //递归调用自己，实现每帧刷新
}

requestAnimationFrame(step)  //传入一个函数，在下一帧执行前渲染，第一次调用
