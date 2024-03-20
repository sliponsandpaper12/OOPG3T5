<template>
  <div
    class="modal-header d-flex flex-column align-items-center justify-content-center"
  >
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
    <div class="mb-3">
      <ul class="list-group list-group-flush fs-4">
        <li class="list-group-item">
          Number of tickets sold for event: {{ ticketSold }} tickets
        </li>
        <li class="list-group-item">
          Revenue generated for event: ${{ revenue }}
        </li>
      </ul>
    </div>
  </div>
  <div class="modal-footer">
    <button
      @click="handleReportGeneration"
      type="button"
      class="w-100 btn btn-success"
    >
      Generate Report for Event
    </button>
    <button
      @click="handleEventCancellation"
      type="button"
      class="mt-3 w-100 btn btn-warning"
    >
      Cancel Event
    </button>
  </div>
</template>
<script>
export default {
  name: "EventStatisticsModal",
  props: ["eventName"],
  components: {},
  data() {
    return {
      revenue: 5000,
      ticketSold: 100,
    };
  },
  methods: {
    handleReportGeneration() {},
    handleEventCancellation() {},
  },
};
</script>
<style scoped></style>
