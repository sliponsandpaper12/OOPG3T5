<template>
  <section class="vh-100">
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col col-xl-10">
          <div
            class="bg-light-subtle card shadow-card"
            style="border-radius: 1rem"
          >
            <div class="row g-0">
              <div class="col-md-6 col-lg-5 d-none d-md-block">
                <img
                  class="w-100 h-100 rounded-4"
                  src="../../assets/images/poster.jpg"
                  alt=""
                />
              </div>
              <div class="col-md-6 col-lg-7 d-flex align-items-center">
                <div class="card-body p-4 p-lg-5 text-black">
                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i
                      class="fas fa-cubes fa-2x me-3"
                      style="color: #ff6219"
                    ></i>
                    <span class="h1 fw-bold mb-0">
                      <img
                        src="../../assets/images/logo.png"
                        class="w-25 h-25"
                      />
                    </span>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                    Sign into your account
                  </h5>

                  <div class="form-outline mb-4">
                    <input
                      type="email"
                      v-model="username"
                      id="form2Example17"
                      class="form-control form-control-lg"
                    />
                    <label class="form-label" for="form2Example17"
                      >Username</label
                    >
                  </div>

                  <div class="form-outline mb-4">
                    <input
                      type="password"
                      v-model="password"
                      id="form2Example27"
                      class="form-control form-control-lg"
                    />
                    <label class="form-label" for="form2Example27"
                      >Password</label
                    >
                  </div>

                  <div class="pt-1 mb-4">
                    <button
                      class="btn btn-dark btn-lg btn-block"
                      type="button"
                      @click="processLogin"
                    >
                      Login
                    </button>
                  </div>

                  <a class="small text-muted" href="#!">Forgot password?</a>
                  <p class="mb-5 pb-lg-2" style="color: #393f81">
                    Don't have an account?
                    <a href="/register" style="color: #393f81">Register here</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import bcrypt from "bcryptjs";
import axios from 'axios';
export default {
  name: "Login",
  components: {},
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    async processLogin() {
      try {
        // Hash the password using bcrypt
        const hashedPassword = await bcrypt.hash(this.password, 0);

        // Send the hashed password to your backend
        const response = await axios.post(
          "http://localhost:8080/user/login",
          {
            username: this.username,
            password: hashedPassword,
          }
        );
        console.log(response.data);
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.shadow-card {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
}
</style>
