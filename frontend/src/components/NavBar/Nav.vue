<template>
  <nav class="navbar navbar-expand-lg bg-white" id="sticky-nav">
    <div class="container-fluid row p-1">
      <div class="col-lg-1 col-2 mx-auto">
        <a class="navbar-brand" href="/events">
          <img
            src="../../assets/images/logo.png"
            style="width: 100px; height: auto"
          />
        </a>
      </div>

      <div class="col-lg-3 col-8"></div>
      <div class="col-2 mx-auto">
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
      <div
        class="col-lg-4 col-sm-3 justify-content-end collapse navbar-collapse"
        id="navbarNav"
      >
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Account
            </a>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="/account">View My Profile</a>
              </li>
              <li>
                <a class="dropdown-item" href="/history">View Booking History</a>
              </li>
              <li>
                <button class="dropdown-item" @click="logOut">Sign Out</button>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script>
export default {
  name: "Nav",
  components: {},
  data() {
    return {};
  },
  methods: {},
};
</script>
<style scoped>
#sticky-nav {
  position: sticky;
  top: 0;
  z-index: 100;
}

a:hover {
  opacity: 0.9; /* Decrease the opacity on hover */
  color: #88fcd7;
}
</style>
