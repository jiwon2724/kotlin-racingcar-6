package racingcar.domain

class Winner {
    fun raceGameWinner(racingRoundResult: Map<String, ArrayList<Int>>): String {
        val winner = StringBuilder(WINNER)
        val moveMaxCount = racingRoundResult.maxBy { racingRound -> racingRound.value.max() }.value.max()

        racingRoundResult.forEach { racingRound ->
            val isMax = racingRound.value.findMax(moveMaxCount)
            if(isMax) winner.append(racingRound.key).append(SPACE_COMMA)
        }
        return winner.toString().removeSuffix(SPACE_COMMA)
    }

    private fun ArrayList<Int>.findMax(maxMoveCount: Int): Boolean = contains(maxMoveCount)

    companion object {
        private const val WINNER = "최종 우승자 : "
        private const val SPACE_COMMA = ", "
    }
}