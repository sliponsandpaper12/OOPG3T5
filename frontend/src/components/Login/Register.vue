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
                  src="../../assets/images/poster1.jpg"
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
                    Register your account
                  </h5>

                  <div class="form-outline mb-4">
                    <input
                      type="email"
                      v-model="emailAddress"
                      id="form2Example17"
                      class="form-control form-control-lg"
                    />
                    <label class="form-label" for="form2Example17"
                      >Email Address</label
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
                      @click="processRegistration"
                    >
                      Register
                    </button>
                  </div>

                  <p class="mb-5 pb-lg-2" style="color: #393f81">
                    Already have an account?
                    <a href="/login" style="color: #393f81">Login now</a>
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
export default {
  name: "Register",
  components: {},
  data() {
    return {
      emailAddress: "",
      password: "",
    };
  },
  methods: {
    processRegistration() {
      //registration logic will go here
      console.log(this.emailAddress);
      console.log(this.password);
    },
  },
};
</script>

<style scoped>
.shadow-card {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
}
</style>
