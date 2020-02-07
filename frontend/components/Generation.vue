<template>
  <div class="has-text-centered">
    <p class="title is-3">
      Click below to reveal an undiscovered truth
    </p>
    <b-button
      @click="generateNews"
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
  },
  methods: {
    async generateNews() {
      const generatedNews = await this.$axios
        .$get('generation')
        .catch((error) => console.log(error))

      console.log(generatedNews)
      this.hasGenerate = true
    }
  }
}
</script>

<style scoped>
.custom-generate-button {
  margin-bottom: 2%;
}
</style>
