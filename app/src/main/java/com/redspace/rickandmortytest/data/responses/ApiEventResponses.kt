package com.redspace.rickandmortytest.data.responses

import com.redspace.rickandmortytest.data.model.RickandMortyResponse

/**
 * Created by Anita Kiran on 05,July,2021
 */
sealed class ApiEventResponses {
    data class CharacterSuccesResponse(val charactersResponse: RickandMortyResponse): ApiEventResponses()
    object LoadingStateEvent : ApiEventResponses()
    object ErrorStateEvent : ApiEventResponses()
    object ApiFailureEvent : ApiEventResponses()

}
