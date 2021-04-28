import { takeLatest, takeEvery } from "redux-saga/effects";
import { getUser, addJob, updateEducation, updateSkill } from "../slices/user";
import {
  handleGetUser,
  handleAddJob,
  handleUpdateDegree,
  handleUpdateSkill,
} from "./handlers/user";

export function* watcherSaga() {
  yield takeLatest(getUser.type, handleGetUser);
  yield takeLatest(addJob.type, handleAddJob);
  yield takeLatest(updateEducation.type, handleUpdateDegree);
  yield takeEvery(updateSkill.type, handleUpdateSkill);
}
