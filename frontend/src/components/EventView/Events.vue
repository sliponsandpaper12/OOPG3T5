<template>
  <div class="container-fluid">
    <div v-if="isAdmin" class="mb-5">
      <button class="btn btn-lg btn-success" @click="addNewEvent">Add New Event</button>
    </div>
    <div class="row">
      <div class="col" v-for="event in events">
        <Event :isAdmin="isAdmin" :eventObj="event" @purchase="openModal" />
      </div>
    </div>
  </div>
  <Teleport to="body">
    <PaymentModal
      :isAdmin="isAdmin"
      :eventName="currEventName"
      :isNewEvent="isNewEvent"
      v-if="displayPayment"
      @close="closeModal"
    />
  </Teleport>
</template>
<script>
import PaymentModal from "./PaymentModal.vue";
import Event from "./Event.vue";
export default {
  name: "Events",
  components: {
    Event,
    PaymentModal,
  },
  data() {
    return {
      isAdmin: true,
      isNewEvent: false,
      currEventName: "",
      displayPayment: false,
      events: [
        {
          name: "Event 1",
          location: "Location 1",
          img: "https://picsum.photos/200/300",
        },
        {
          name: "Event 2",
          location: "Location 2",
          img: "https://picsum.photos/200/300",
        },
        {
          name: "Event 3",
          location: "Location 3",
          img: "https://picsum.photos/200/300",
        },
      ],
    };
  },
  methods: {
    getAllEvents() {
      //use axios to fetch all events to display store in events data.
    },
    openModal(eventName, isCreate) {
      console.log(eventName);
      if (isCreate){
        this.isNewEvent=true;
      }else{
        this.isNewEvent=false;
      }
      this.currEventName = eventName;
      this.displayPayment = true;
    },
    closeModal() {
      this.displayPayment = false;
    },
    addNewEvent(){
      this.openModal("", true);
    }
  },
};
</script>
<style scoped>

</style>
