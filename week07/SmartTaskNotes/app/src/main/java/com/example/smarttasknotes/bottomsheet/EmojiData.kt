package com.example.smarttasknotes.bottomsheet

enum class EmojiCategory(val label: String) {
    ALL("전체"),
    FACE("얼굴"),
    NATURE("자연"),
    FOOD("음식"),
    ACTIVITY("활동"),
    TRAVEL("여행"),
    OBJECT("사물"),
}

data class EmojiItem(
    val emoji: String,
    val category: EmojiCategory
)

val emojiList = listOf(
    // 얼굴
    EmojiItem("😀", EmojiCategory.FACE),
    EmojiItem("😂", EmojiCategory.FACE),
    EmojiItem("🥲", EmojiCategory.FACE),
    EmojiItem("😍", EmojiCategory.FACE),
    EmojiItem("🤔", EmojiCategory.FACE),
    EmojiItem("😎", EmojiCategory.FACE),
    EmojiItem("🥳", EmojiCategory.FACE),
    EmojiItem("😤", EmojiCategory.FACE),
    EmojiItem("😭", EmojiCategory.FACE),
    EmojiItem("🤯", EmojiCategory.FACE),
    EmojiItem("🤗", EmojiCategory.FACE),
    EmojiItem("😴", EmojiCategory.FACE),
    EmojiItem("🥺", EmojiCategory.FACE),
    EmojiItem("😅", EmojiCategory.FACE),
    EmojiItem("🫡", EmojiCategory.FACE),
    EmojiItem("🤩", EmojiCategory.FACE),

    // 자연
    EmojiItem("🌸", EmojiCategory.NATURE),
    EmojiItem("🌿", EmojiCategory.NATURE),
    EmojiItem("🌊", EmojiCategory.NATURE),
    EmojiItem("⭐", EmojiCategory.NATURE),
    EmojiItem("🌙", EmojiCategory.NATURE),
    EmojiItem("☀️", EmojiCategory.NATURE),
    EmojiItem("🌈", EmojiCategory.NATURE),
    EmojiItem("❄️", EmojiCategory.NATURE),
    EmojiItem("🌺", EmojiCategory.NATURE),
    EmojiItem("🍀", EmojiCategory.NATURE),
    EmojiItem("🌻", EmojiCategory.NATURE),
    EmojiItem("🌵", EmojiCategory.NATURE),

    // 음식
    EmojiItem("🍕", EmojiCategory.FOOD),
    EmojiItem("🍣", EmojiCategory.FOOD),
    EmojiItem("🍜", EmojiCategory.FOOD),
    EmojiItem("🍔", EmojiCategory.FOOD),
    EmojiItem("🍩", EmojiCategory.FOOD),
    EmojiItem("☕", EmojiCategory.FOOD),
    EmojiItem("🍺", EmojiCategory.FOOD),
    EmojiItem("🍓", EmojiCategory.FOOD),
    EmojiItem("🥑", EmojiCategory.FOOD),
    EmojiItem("🌮", EmojiCategory.FOOD),
    EmojiItem("🍦", EmojiCategory.FOOD),
    EmojiItem("🧇", EmojiCategory.FOOD),

    // 활동
    EmojiItem("🏃", EmojiCategory.ACTIVITY),
    EmojiItem("🏋️", EmojiCategory.ACTIVITY),
    EmojiItem("🧘", EmojiCategory.ACTIVITY),
    EmojiItem("🎮", EmojiCategory.ACTIVITY),
    EmojiItem("📚", EmojiCategory.ACTIVITY),
    EmojiItem("🎨", EmojiCategory.ACTIVITY),
    EmojiItem("🎵", EmojiCategory.ACTIVITY),
    EmojiItem("⚽", EmojiCategory.ACTIVITY),
    EmojiItem("🏊", EmojiCategory.ACTIVITY),
    EmojiItem("🚴", EmojiCategory.ACTIVITY),
    EmojiItem("🎯", EmojiCategory.ACTIVITY),
    EmojiItem("🧩", EmojiCategory.ACTIVITY),

    // 여행
    EmojiItem("✈️", EmojiCategory.TRAVEL),
    EmojiItem("🏖️", EmojiCategory.TRAVEL),
    EmojiItem("🗺️", EmojiCategory.TRAVEL),
    EmojiItem("🏕️", EmojiCategory.TRAVEL),
    EmojiItem("🗼", EmojiCategory.TRAVEL),
    EmojiItem("🚂", EmojiCategory.TRAVEL),
    EmojiItem("🚢", EmojiCategory.TRAVEL),
    EmojiItem("🏔️", EmojiCategory.TRAVEL),
    EmojiItem("🎡", EmojiCategory.TRAVEL),
    EmojiItem("🌍", EmojiCategory.TRAVEL),

    // 사물
    EmojiItem("📝", EmojiCategory.OBJECT),
    EmojiItem("✅", EmojiCategory.OBJECT),
    EmojiItem("📅", EmojiCategory.OBJECT),
    EmojiItem("💡", EmojiCategory.OBJECT),
    EmojiItem("🔥", EmojiCategory.OBJECT),
    EmojiItem("💰", EmojiCategory.OBJECT),
    EmojiItem("🎁", EmojiCategory.OBJECT),
    EmojiItem("📱", EmojiCategory.OBJECT),
    EmojiItem("💊", EmojiCategory.OBJECT),
    EmojiItem("🔑", EmojiCategory.OBJECT),
    EmojiItem("📷", EmojiCategory.OBJECT),
    EmojiItem("🎀", EmojiCategory.OBJECT),
)
