<template>
  <div class="card" style="">
    <img :src="eventObj.img" class="card-img-top" alt="..." />
    <div class="card-body">
      <h5 class="card-title">{{ eventObj.name }}</h5>
      <p class="card-text">{{ eventObj.location }}</p>
      <button v-if="!isAdmin" @click="processPurchase" class="btn btn-primary">Purchase Ticket</button>
      <button v-if="isAdmin" @click="processPurchase" class="btn btn-primary">Update Event</button>
    </div>
  </div>
</template>
<script>
export default {
  props: ["eventObj", "isAdmin"],
  emits: ["purchase"],
  name: "Event",
  components: {},
  data() {
    return {
       
    };
  },
  methods: {
    processPurchase(){
        this.$emit("purchase", this.eventObj.name)
    }
  },
};
</script>
<style scoped></style>
