import { configureStore } from "@reduxjs/toolkit";
import userReducer from "./slices/user";
import searchReducer from "./slices/search";

export default configureStore({
  reducer: {
    user: userReducer,
    search: searchReducer,
  },
});
