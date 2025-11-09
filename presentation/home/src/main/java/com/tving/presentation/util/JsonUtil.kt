package com.tving.presentation.util

import com.tving.presentation.model.ImageInfoUiModel
import com.tving.presentation.model.PixaUiModel
import com.tving.presentation.model.VideoInfoUiModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object JsonUtil {
    val pixaModule = SerializersModule {
        polymorphic(PixaUiModel::class) {
            subclass(ImageInfoUiModel::class)
            subclass(VideoInfoUiModel::class)
        }
    }
    val pixaJson = Json {
        serializersModule = pixaModule
        classDiscriminator = "type"
    }
}
