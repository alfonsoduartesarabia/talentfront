import { createSlice } from "@reduxjs/toolkit";

export const searchSlice = createSlice({
    name: "search",
    initialState: {},
    reducers: {
        getSearch(state) {
            console.log("getting search query")
            return state.search
        },
        setSearch: (state, action) => {
            const searchData = action.payload;
            return { ...state, ...searchData };
        },
        updateQuery: (state, action) => {
            console.log(`action payload is: ${JSON.stringify(action)}`)
            state.search = action.payload;
        },
    },
});

export const { getSearch, setSearch, updateQuery } = searchSlice.actions;

export const selectSearch = (state) => state.search.search;

export default searchSlice.reducer;
