package com.example.testapp.json.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testapp.json.JSONAPI

class UserPagingSource(private val apiService: JSONAPI) : PagingSource<Int, UserDatawithName>() {
    override fun getRefreshKey(state: PagingState<Int, UserDatawithName>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserDatawithName> {
        return try {
            val position = params.key ?: 1
            val response = apiService.getPhotoswithId(position)
            LoadResult.Page(
                data = response.body()!!.asList(),
                prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}