import {
  configureStore,
  combineReducers,
  getDefaultMiddleware,
} from "@reduxjs/toolkit";
import userReducer from "./slices/user";
import searchReducer from "./slices/search";
import createSagaMiddleware from "redux-saga";
import { watcherSaga } from "./sagas/rootSaga";

const sagaMiddleWare = createSagaMiddleware();

const reducer = combineReducers({ user: userReducer, search: searchReducer });

const store = configureStore({
  reducer,
  middleware: [...getDefaultMiddleware({ thunk: false }), sagaMiddleWare],
  devTools: true,
});

sagaMiddleWare.run(watcherSaga);

export default store;
