package be.swsb.effit.domain.query.competition

import be.swsb.effit.adapter.sql.competition.CompetitionRepository
import be.swsb.effit.domain.core.competition.Competition
import be.swsb.effit.domain.core.exceptions.EntityNotFoundDomainRuntimeException
import be.swsb.effit.domain.query.QueryHandler
import org.springframework.stereotype.Component

@Component
class FindCompetitionQueryHandler(val competitionRepository: CompetitionRepository) : QueryHandler<Competition, FindCompetition> {
    override fun handle(query: FindCompetition): Competition {
        return competitionRepository.findByCompetitionIdentifier(query.id)
                ?: throw EntityNotFoundDomainRuntimeException("Competition with id ${query.id.id} not found")
    }

    override fun getQueryType(): Class<FindCompetition> {
        return FindCompetition::class.java
    }
}
