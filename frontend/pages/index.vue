<template>
  <div>
    <section class="hero is-info is-bold custom-hero" info>
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Fake news
          </h1>
          <h2 class="subtitle">
            Because the worlds needs YOUR truth
          </h2>
        </div>
      </div>
    </section>
    <Stats></Stats>
    <div class="container">
      <div class="tile is-ancestor">
        <div class="tile is-8 custom-tile is-block">
          <b-tabs>
            <b-tab-item label="Generation" icon="plus">
              <Generation class="margin-below-tabs" />
            </b-tab-item>
            <b-tab-item label="Submission" icon="upload"></b-tab-item>
          </b-tabs>
        </div>
        <div class="tile box is-4 has-background-light custom-tile">
          <History />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Stats from '../components/Stats'
import Generation from '../components/Generation'
import History from '../components/History'
export default {
  name: 'HomePage',
  components: { History, Generation, Stats },
  data() {
    return {
      generation: true
    }
  }
}
</script>

<style scoped>
.custom-hero {
  margin-bottom: 2%;
}
.custom-tile {
  margin: 0 2% 2%;
}
.margin-below-tabs {
  margin-top: 2%;
}
</style>
