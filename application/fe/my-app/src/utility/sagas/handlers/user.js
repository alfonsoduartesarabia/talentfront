import { call, put } from "redux-saga/effects";
import {
  getUser,
  postJobUser,
  postEducationUser,
  postSkill,
} from "../requests/user";
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

export function* handleAddJob(action) {
  try {
    const response = yield call(postJobUser, action);
    const { data } = response;
    console.log(response);
    // yield put(setUser(data));
  } catch (err) {
    console.log(err);
  }
}

export function* handleUpdateDegree(action) {
  try {
    const response = yield call(postEducationUser, action);
  } catch (err) {
    console.log(err);
  }
}

export function* handleUpdateSkill(action) {
  try {
    const response = yield call(postSkill, action);
  } catch (err) {
    console.log(err);
  }
}
