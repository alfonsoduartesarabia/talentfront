import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import userReducer from "../features/user/slice"

export default configureStore({
  reducer: {
    counter: counterReducer,
    user: userReducer,
  },
});
