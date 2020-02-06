<template>
  <div class="has-text-centered">
    <p class="title is-3">
      Click below to reveal an undiscovered truth
    </p>
    <b-button
      @click="hasGenerate = !hasGenerate"
      type="is-primary custom-generate-button"
      size="is-medium"
    >
      Generate
    </b-button>
    <Box v-if="hasGenerate" />
  </div>
</template>

<script>
import Box from '../components/Box'
export default {
  name: 'Generation',
  components: { Box },
  data() {
    return {
      hasGenerate: false
    }
  }
}
</script>

<style scoped>
.custom-generate-button {
  margin-bottom: 2%;
}
</style>
