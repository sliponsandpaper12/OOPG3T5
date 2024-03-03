<template>
  <div class="container-fluid">
    <div v-if="isAdmin" class="mb-5">
      <button class="btn btn-lg btn-success" @click="openModal('create')">
        Add New Event
      </button>
    </div>
    <div class="row">
      <div class="col" v-for="event in events">
        <Event
          :isAdmin="isAdmin"
          :eventObj="event"
          @open="openModal"
        />
      </div>
    </div>
  </div>
  <Teleport to="body">
    <MainModal
      v-if="isOpen"
      :eventName="currEventName"
      :type="reqType"
      @close="closeModal"
    />
  </Teleport>
</template>
<script>
import MainModal from "./MainModal.vue";
import Event from "./Event.vue";
export default {
  name: "Events",
  components: {
    Event,
    MainModal
  },
  data() {
    return {  
      isAdmin: true,
      isOpen: false,
      currEventName: "",
      reqType: "",
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
    openModal(event){
      console.log(event);
      if (!Array.isArray(event)){
        this.reqType = event;
      }else{
        this.reqType=event[1];
        this.currEventName = event[0];
      }  
      this.isOpen = true;
      console.log(this.reqType);
    },
    closeModal(){
      this.isOpen=false;
    }
  },
};
</script>
<style scoped></style>
