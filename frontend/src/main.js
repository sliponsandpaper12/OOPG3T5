import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
import { createRouter, createWebHistory } from "vue-router";
import Login from "./components/Login/Login.vue";
import Register from "./components/Login/Register.vue";
import Events from "./components/EventView/Events.vue";
const routes = [
  {
    path: "/login",
    component: Login,
  },
  {
    path: "/register",
    component: Register,
  },
  {
    path: "/events",
    component: Events,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});
createApp(App).use(router).mount("#app");
