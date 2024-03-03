<template>
  <div class="modal-overlay rounded-5">
    <div class="modal-dialog p-5">
      <div class="modal-content">
        <PaymentModal :eventName="eventName" v-if="type == 'purchase'" />
        <CreateEventModal v-if="type == 'create'" />
        <UpdateEventModal :eventName="eventName" v-if="type == 'update'" />
        <EventStatisticsModal :eventName="eventName" v-if="type == 'statistics'" />
        <button
          type="button"
          class="mt-3 btn btn-danger w-100"
          @click="this.$emit('close')"
        >
          Close
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import PaymentModal from "./PaymentModal.vue";
import CreateEventModal from "./CreateEventModal.vue";
import EventStatisticsModal from "./EventStatisticsModal.vue";
import UpdateEventModal from "./UpdateEventModal.vue";

export default {
  name: "MainModal",
  props: ["eventName", "type"],
  components: {
    PaymentModal,
    CreateEventModal,
    UpdateEventModal,
    EventStatisticsModal,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>
<style scoped>
.modal-overlay {
  margin-left: auto;
  margin-right: auto;
  position: fixed;
  width: 60%;
  height: 60%;
  background-color: rgb(255, 255, 255);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
}
.modal-dialog {
  width: 80%;
  overflow-y: auto;
  max-height: 100%;
}
</style>
