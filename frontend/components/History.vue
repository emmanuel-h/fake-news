<template>
  <div>
    <p class="title is-4">Latest revelations</p>
    <Box key v-for="box in boxes" :key="box.id" />
  </div>
</template>

<script>
import Box from './Box'
export default {
  name: 'History',
  components: { Box },
  data() {
    return {
      boxes: [
        {
          id: 1,
          text: 'blablabla'
        },
        {
          id: 2,
          text: 'dslgj'
        },
        {
          id: 3,
          text: 'sdgfmrlkdg'
        },
        {
          id: 4,
          text: 'dflkgjdlfkgj'
        }
      ]
    }
  }
}
</script>

<style scoped></style>
