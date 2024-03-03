<template>
  <div class="modal-header d-flex align-items-center justify-content-center">
    <h2 class="modal-title text-center">{{ eventName }}</h2>
  </div>
  <div
    class="modal-body d-flex flex-column align-items-center justify-content-center"
  >
    <img
      src="https://picsum.photos/200/300"
      class="w-75 h-75 mb-3 mt-4"
      alt=""
    />
    <div class="mb-3 w-50">
      <label for="exampleInputEmail1" class="form-label"
        >Number of Tickets</label
      >
      <input
        type="number"
        max="5"
        min="1"
        class="form-control"
        id="exampleInputEmail1"
        aria-describedby="emailHelp"
      />
      <div id="emailHelp" class="form-text text-warning">
        * Limited to 5 tickets
      </div>
    </div>
    <div class="mb-5 w-50">
      <label for="exampleInputPassword1" class="form-label"
        >Payment Details
      </label>
      <input type="text" class="form-control" id="exampleInputPassword1" />
    </div>
  </div>
  <div class="modal-footer">
    <button @click="handlePurchase" type="button" class="w-100 btn btn-success">
      Purchase Now
    </button>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "PaymentModal",
  props: ["eventName"],
  emits: ["close"],
  components: {},
  data() {
    return {};
  },
  methods: {
    handlePurchase() {
      //axios call to handle the purchase
    },
  },
};
</script>
<style scoped></style>
