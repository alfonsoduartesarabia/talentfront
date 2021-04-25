import { call, put } from "redux-saga/effects";
import { getUser } from "../requests/user";
import { setUser } from "../../slices/user";

export function* handleGetUser(action) {
  try {
    const response = yield call(getUser);
    const { data } = response;
    yield put(setUser(data));
  } catch (err) {
    console.log(err);
  }
}
