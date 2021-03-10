package com.greedygametest.modles


import com.google.gson.annotations.SerializedName

data class TestModle(
    @SerializedName("properties")
    val properties: Properties,
    @SerializedName("type")
    val type: String
) {
    data class Properties(
        @SerializedName("bar")
        val bar: Bar,
        @SerializedName("baz")
        val baz: Baz,
        @SerializedName("foo")
        val foo: Foo
    ) {
        data class Bar(
            @SerializedName("type")
            val type: String
        )

        data class Baz(
            @SerializedName("type")
            val type: String
        )

        data class Foo(
            @SerializedName("type")
            val type: String
        )
    }
}