<template>
  <div class="modal-header d-flex flex-column align-items-center justify-content-center">
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
      <label for="exampleInputEmail1" class="form-label"> Event name </label>
      <input
        type="number"
        max="5"
        min="1"
        class="form-control"
        id="exampleInputEmail1"
        aria-describedby="emailHelp"
      />
    </div>
    <div class="mb-3 w-50">
      <label for="exampleInputPassword1" class="form-label">Venue</label>
      <input type="text" class="form-control" id="exampleInputPassword1" />
    </div>
    <div class="mb-3 w-50">
      <label for="exampleInputPassword1" class="form-label"
        >Date and time</label
      >
      <input type="text" class="form-control" id="exampleInputPassword1" />
    </div>
    <div class="mb-3 w-50">
      <label for="exampleInputPassword1" class="form-label">Ticket Price</label>
      <input type="text" class="form-control" id="exampleInputPassword1" />
    </div>
    <div class="mb-5 w-50">
      <label for="exampleInputPassword1" class="form-label"
        >Number of Tickets Available</label
      >
      <input type="text" class="form-control" id="exampleInputPassword1" />
    </div>
  </div>
  <div class="modal-footer">
    <button @click="handleUpdate" type="button" class="w-100 btn btn-success">
      Update Event
    </button>
  </div>
</template>
<script>
export default {
  name: "UpdateEventModal",
  props:["eventName"],
  components: {},
  data() {
    return {};
  },
  methods: {
    handleUpdate(){
      //axios to update event.
    }
  },
};
</script>
<style scoped></style>
