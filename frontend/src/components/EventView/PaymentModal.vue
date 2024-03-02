<template>
  <div class="modal-overlay rounded-5">
    <div class="modal-dialog p-5">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">{{ eventName }}</h5>
        </div>
        <span v-if="!isAdmin">
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
              <input
                type="text"
                class="form-control"
                id="exampleInputPassword1"
              />
            </div>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="me-1 btn btn-danger"
              @click="this.$emit('close')"
            >
              Close
            </button>
            <button
              @click="handlePurchase"
              type="button"
              class="ms-1 btn btn-success"
            >
              Purchase Now
            </button>
          </div>
        </span>
        <span v-else>
          <div
            class="modal-body d-flex flex-column align-items-center justify-content-center"
          >
            <img
              src="https://picsum.photos/200/300"
              class="w-75 h-75 mb-3 mt-4"
              alt=""
            />
            <div class="mb-3 w-50">
              <label for="exampleInputEmail1" class="form-label">
                Event name
              </label>
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
              <label for="exampleInputPassword1" class="form-label"
                >Venue</label
              >
              <input
                type="text"
                class="form-control"
                id="exampleInputPassword1"
              />
            </div>
            <div class="mb-3 w-50">
                <label for="exampleInputPassword1" class="form-label"
                  >Date and time</label
                >
                <input
                  type="text"
                  class="form-control"
                  id="exampleInputPassword1"
                />
              </div>
              <div class="mb-3 w-50">
                <label for="exampleInputPassword1" class="form-label"
                  >Ticket Price</label
                >
                <input
                  type="text"
                  class="form-control"
                  id="exampleInputPassword1"
                />
              </div>
              <div class="mb-5 w-50">
                <label for="exampleInputPassword1" class="form-label"
                  >Number of Tickets Available</label
                >
                <input
                  type="text"
                  class="form-control"
                  id="exampleInputPassword1"
                />
              </div>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="me-1 btn btn-warning"
              @click="this.$emit('close')"
            >
              Close
            </button>
            <span v-if="!isNewEvent">
                <button
                  @click="deleteEvent"
                  type="button"
                  class="ms-1 btn btn-danger"
                >
                  Cancel Event
                </button>
                <button
                  @click="handleUpdate"
                  type="button"
                  class="ms-1 btn btn-success"
                >
                  Update Event
                </button>
            </span>
            <span v-else>
                <button
                    @click="createEvent"
                    type="button"
                    class="ms-1 btn btn-danger"
                >
                    Create New Event
                </button>
            </span>
          </div>
        </span>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "PaymentModal",
  props: ["eventName", "isAdmin", "isNewEvent"],
  emits: ["close"],
  components: {},
  data() {
    return {};
  },
  methods: {
    handlePurchase() {
      //axios call to handle the purchase
    },
    handleUpdate() {
        //axios call to update event details ==> for admin only.
    },
    deleteEvent() {
        //axios call to delete the event
    },
    createEvent(){
        
    }
  },
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
