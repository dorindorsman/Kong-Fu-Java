package dorin_roman.app.kongfujava.domain.source

import androidx.room.Database
import androidx.room.RoomDatabase
import dorin_roman.app.kongfujava.domain.models.World
import dorin_roman.app.kongfujava.domain.models.levels.Answer
import dorin_roman.app.kongfujava.domain.models.levels.Level
import dorin_roman.app.kongfujava.domain.models.levels.Question
import dorin_roman.app.kongfujava.domain.models.levels.Tutorial

@Database(
    entities = [World::class, Level::class, Answer::class, Question::class, Tutorial::class],
    version = 1,
    exportSchema = true
)
abstract class KongFuDataBase : RoomDatabase() {

    abstract fun worldDao(): WorldDao

    abstract fun levelDao(): LevelDao

}