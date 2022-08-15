import { createStore } from 'vuex'
import ModuleUser from './user'
import ModulePk from "@/store/pk";

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user: ModuleUser,
    pk: ModulePk
  }
})
