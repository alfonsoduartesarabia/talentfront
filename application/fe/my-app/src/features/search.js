import { createSlice } from '@reduxjs/toolkit';

export const searchSlice = createSlice({
  name: 'user',
  initialState: {
    query: {
      "filter": "",
      "subFilter": "",
      "searchTerm": ""
    }
  },
  reducers: {
    updateQuery: (state, action) => {
      state.query = action.payload
    },
    clearQuery: (state, action) => {
      state.query = {
        "filter": "",
        "subFilter": "",
        "searchTerm": ""
      } 
    }
  }
})

export const { updateQuery, clearQuery } = searchSlice.actions

export default searchSlice.reducer