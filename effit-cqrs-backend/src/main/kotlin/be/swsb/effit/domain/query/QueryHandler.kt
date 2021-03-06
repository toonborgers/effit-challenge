package be.swsb.effit.domain.query

interface QueryHandler<out R, Q : Query<out R>> {
    fun handle(query: Q): R
    fun getQueryType(): Class<Q>
}
