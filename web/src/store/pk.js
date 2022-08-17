

export default {
    state: {
        status: "matching",  // 状态matching表示匹配界面，playing表示对战界面
        socket: null, //存储建立的链接

        //对手信息
        opponent_username: "",
        opponent_photo: "",

        //地图
        gamemap: null,
    },
    getters: {
    },
    mutations: {
        //创建连接时存储到store
        updateSocket(state, socket) {
            state.socket = socket;
        },
        updateOpponent(state, opponent) {
            state.opponent_username = opponent.username;
            state.opponent_photo = opponent.photo;
        },
        updateStatus(state, status) {
            state.status = status;
        },
        updateGamemap(state, gamemap) {
            state.gamemap = gamemap;
        }
    },
    actions: {
    },
    modules: {
    }
}
