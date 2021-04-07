import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import userReducer from "../features/user/slice"
import searchReducer from "../features/search"

export default configureStore({
  reducer: {
    counter: counterReducer,
    user: userReducer,
    search: searchReducer
  },
});
