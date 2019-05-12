import Vue from 'vue';
import Router from 'vue-router';
import CompetitionsOverview from './views/CompetitionsOverview.vue';
import ChallengesOverview from './views/ChallengesOverview.vue';
import CompetitionDetail from './views/CompetitionDetail.vue';
import CreateChallenge from './views/CreateChallenge.vue';
import CreateCompetition from './views/CreateCompetition.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      name: 'challenges',
      path: '/challenges',
      component: ChallengesOverview,
    },
    {
      name: 'CreateChallenge',
      path: '/challenges/create',
      component: CreateChallenge,
    },
    {
      name: 'competitions',
      path: '/competitions',
      component: CompetitionsOverview,
    },
    {
      name: 'CreateCompetition',
      path: '/competitions/create',
      component: CreateCompetition,
    },
    {
      name: 'competitionDetail',
      path: '/competitions/:competitionId',
      component: CompetitionDetail,
      props: true,
    },
    {
      name: 'about',
      path: '/about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue'),
    },
  ],
});
