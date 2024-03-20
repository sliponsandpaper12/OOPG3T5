<template>
  <div class="card" style="">
    <img :src="eventObj.img" class="card-img-top" alt="..." />
    <div class="card-body">
      <h5 class="card-title">{{ eventObj.name }}</h5>
      <p class="card-text">{{ eventObj.location }}</p>
      <button v-if="!isAdmin" @click="handleOpen('purchase')" class="btn btn-primary">Purchase Ticket</button>
      <span class="d-flex flex-column align-items-center justify-content-center" v-else>
        <button @click="handleOpen('update')" class="mb-3 btn btn-primary">Update Event</button>
        <button @click="handleOpen('statistics')" class="btn btn-dark">View Sales Statistics</button>
      </span>
    </div>
  </div>
</template>
<script>
export default {
  props: ["eventObj", "isAdmin"],
  emits: ["open"],
  name: "Event",
  components: {},
  data() {
    return {
       
    };
  },
  methods: {
    handleOpen(event){
        this.$emit("open", [this.eventObj.name, event])
    },
  },
};
</script>
<style scoped></style>
