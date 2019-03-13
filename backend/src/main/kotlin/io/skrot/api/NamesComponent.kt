package io.skrot.api

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/names")
class NamesComponent {

    data class Person(val name: String)
    data class ListResponse(val people: List<Person>)

    private var people = mutableListOf<Person>()

    @Path("/")
    @GET @Produces(MediaType.APPLICATION_JSON)
    fun list(): ListResponse {
        return ListResponse(people)
    }

    @Path("/")
    @POST @Consumes(MediaType.APPLICATION_JSON)
    fun add(person: Person) {
        people.add(person)
    }
}