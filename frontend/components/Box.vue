<template>
  <div class="box">
    <article class="media">
      <div class="media-left">
        <figure class="image is-64x64">
          <img
            src="https://bulma.io/images/placeholders/128x128.png"
            alt="Image"
          />
        </figure>
      </div>
      <div class="media-content">
        <div class="content">
          <p>
            <strong>John Smith</strong> <small>@johnsmith</small>
            <small>31m</small>
            <br />
            {{ news }}
          </p>
        </div>
        <nav class="level is-mobile">
          <div class="level-left">
            <a class="level-item" aria-label="reply">
              <span class="icon is-small">
                <font-awesome-icon :icon="['fab', 'twitter']" />
              </span>
            </a>
            <a class="level-item" aria-label="retweet">
              <span class="icon is-small">
                <font-awesome-icon :icon="['far', 'envelope']" />
              </span>
            </a>
            <a class="level-item" aria-label="like">
              <span class="icon is-small">
                <font-awesome-icon :icon="['far', 'copy']" />
              </span>
            </a>
          </div>
        </nav>
      </div>
    </article>
  </div>
</template>

<script>
import { fas } from '@fortawesome/free-solid-svg-icons'
import { faGithub } from '@fortawesome/free-brands-svg-icons'
export default {
  props: {
    news: {
      type: String,
      default:
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'
    }
  },
  computed: {
    fas() {
      return fas
    },
    faGithub() {
      return faGithub
    }
  }
}
</script>

<style scoped></style>
