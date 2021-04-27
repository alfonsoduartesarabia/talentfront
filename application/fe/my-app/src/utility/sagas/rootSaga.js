import { takeLatest } from "redux-saga/effects";
import { getUser, addJob, updateEducation } from "../slices/user";
import {
  handleGetUser,
  handleAddJob,
  handleUpdateDegree,
} from "./handlers/user";

export function* watcherSaga() {
  yield takeLatest(getUser.type, handleGetUser);
  yield takeLatest(addJob.type, handleAddJob);
  yield takeLatest(updateEducation.type, handleUpdateDegree);
}
