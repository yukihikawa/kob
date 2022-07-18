<template>
  <div ref="parent" class="gamemap">
<!--ref关联-->
<!--    canvas画布，绘制2D图形-->
    <canvas ref="canvas">
        dfghsbgfd
    </canvas>
  </div>

</template>

<script>
import { GameMap } from "@/assets/scripts/GameMap";
import { ref, onMounted } from 'vue'

export default {
  setup() {
    let parent = ref(null);
    let canvas = ref(null);
    //一开始没指向任何元素

    //挂载函数，组件挂载完后执行的操作，创建GameMap
    onMounted(() => {
      new GameMap(canvas.value.getContext('2d'), parent.value)
    });

    return {
      parent,
      canvas //返回后可以建立关联
    }
  }

}
</script>

<style scoped>
div.gamemap {
  width: 100%;
  height: 100%;
  display: flex;

  /*居中*/
  justify-content: center;
  align-items: center;

}

</style>
