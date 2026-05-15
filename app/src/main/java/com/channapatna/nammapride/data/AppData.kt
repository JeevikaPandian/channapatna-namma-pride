package com.channapatna.nammapride.data

import com.channapatna.nammapride.model.*

object AppData {

    // ─── Toy verification DB (would normally come from Firebase) ────────────
    val toyDatabase: Map<String, ToyVerification> = mapOf(
        "423781" to ToyVerification(
            artisan = "Ramu Shilpi",
            avatar = "👨‍🎨",
            village = "Channapatna Town",
            years = 28,
            specialty = "Spinning Tops & Bowls",
            toy = "Hand-Turned Spinning Top",
            lac = "Red Lac (Natural)",
            batch = "Batch #RT-2026-03",
            status = "verified"
        ),
        "195023" to ToyVerification(
            artisan = "Meena Devi",
            avatar = "👩‍🎨",
            village = "GI Craft Village",
            years = 15,
            specialty = "Nesting Dolls & Figurines",
            toy = "Matryoshka Nesting Doll Set",
            lac = "Multi-Lac (Saffron/Green)",
            batch = "Batch #MD-2026-01",
            status = "verified"
        ),
        "777001" to ToyVerification(
            artisan = "Prakash Kumar",
            avatar = "👨‍🔧",
            village = "KIADB Channapatna",
            years = 34,
            specialty = "Rocking Horses & Large Toys",
            toy = "Traditional Rocking Horse",
            lac = "Golden Lac + Green Trim",
            batch = "Batch #PK-2026-05",
            status = "verified"
        )
    )

    // ─── Catalogue toys ─────────────────────────────────────────────────────
    val toys: List<Toy> = listOf(
        Toy("Hand-Turned Spinning Top", "Ramu Shilpi", "₹280", "tops", "🌀", "#FFF3E0", true),
        Toy("Matryoshka Nesting Dolls", "Meena Devi", "₹850", "dolls", "🪆", "#F3E5F5", true),
        Toy("Traditional Rocking Horse", "Prakash Kumar", "₹2,400", "horses", "🐴", "#E8F5E9", true),
        Toy("Elephant Figurine", "Kavitha B", "₹420", "animals", "🐘", "#E3F2FD", true),
        Toy("Wooden Puzzle Set", "Ramu Shilpi", "₹650", "puzzles", "🧩", "#FBE9E7", true),
        Toy("Animal Parade Set", "Kavitha B", "₹1,100", "animals", "🦁", "#FFFDE7", true),
        Toy("Rainbow Top Collection", "Meena Devi", "₹360", "tops", "🔴", "#FCE4EC", true),
        Toy("Camel Figurine", "Ramu Shilpi", "₹380", "animals", "🐪", "#F1F8E9", true)
    )

    // ─── Artisans ────────────────────────────────────────────────────────────
    val artisans: List<Artisan> = listOf(
        Artisan("Ramu Shilpi", "👨‍🎨", "Spinning Tops", 4.9),
        Artisan("Meena Devi", "👩‍🎨", "Nesting Dolls", 4.8),
        Artisan("Prakash K", "👨‍🔧", "Rocking Horses", 5.0),
        Artisan("Kavitha B", "👩‍🏭", "Animal Figures", 4.7)
    )

    // ─── Workshops ───────────────────────────────────────────────────────────
    val workshops: List<Workshop> = listOf(
        Workshop(
            "Shilpa Gram — Master Artisan Hub",
            "NH48, Channapatna, Ramanagara Dist.",
            "Mon–Sat: 9AM–6PM",
            "🔨",
            12.6513, 77.2036
        ),
        Workshop(
            "Ramu Shilpi's Lac Workshop",
            "3rd Cross, Toymaker Lane, Channapatna",
            "Tue–Sun: 8AM–5PM",
            "🎨",
            12.6520, 77.2045
        ),
        Workshop(
            "Karnataka Khadi Gramodyog",
            "Market Rd, Channapatna Town",
            "Mon–Fri: 10AM–7PM",
            "🏺",
            12.6505, 77.2028
        ),
        Workshop(
            "Meena Devi's Nesting Doll Studio",
            "GI Craft Village, Channapatna",
            "Wed–Mon: 9AM–4PM",
            "🌿",
            12.6530, 77.2060
        ),
        Workshop(
            "Prakash Heritage Toy Exports",
            "KIADB Industrial Area, Channapatna",
            "Mon–Sat: 8AM–6PM",
            "🎠",
            12.6495, 77.2015
        )
    )

    // ─── Craft process steps ─────────────────────────────────────────────────
    val processSteps: List<ProcessStep> = listOf(
        ProcessStep(
            1,
            "🌳 Hale Wood Selection",
            "Artisans carefully select Wrightia tinctoria (Hale wood), prized for its softness and ability to hold lac pigment. Only sustainably harvested timber is used.",
            "#FF8C00", "#FF6B35"
        ),
        ProcessStep(
            2,
            "🔄 Lathe Turning",
            "The wood blank is mounted on a foot-operated lathe. The artisan shapes it using hand-held chisels, creating the toy form through centuries-old turning techniques.",
            "#2D7A4F", "#4CAF78"
        ),
        ProcessStep(
            3,
            "🎨 Lac Application",
            "Natural lac (resin from Laccifer lacca insects) is pressed against the spinning wood. Frictional heat melts the lac, fusing brilliant colors into the grain without any synthetic dyes.",
            "#CC3333", "#FF6B6B"
        ),
        ProcessStep(
            4,
            "✨ Polishing & Finishing",
            "The toy is hand-polished to a smooth, glossy finish. Non-toxic, child-safe lacquer protects the surface while preserving the vibrant colors for decades.",
            "#7C3AED", "#9F5FEF"
        ),
        ProcessStep(
            5,
            "🏷️ GI Tag & ID Assignment",
            "Each finished toy receives a unique 6-digit Toy ID registered in Firebase Firestore, linking it permanently to the artisan and batch for buyer verification.",
            "#FF8C00", "#FFD700"
        )
    )

    // ─── NammaBot system prompt ───────────────────────────────────────────────
    const val NAMMABOT_SYSTEM_PROMPT = """You are NammaBot, an enthusiastic AI heritage guide for the Channapatna Namma Pride app — a platform dedicated to authentic Channapatna lacquered wooden toys from Karnataka, India.

Your expertise covers:
- Channapatna craft history (centuries-old tradition, UNESCO recognition)
- The lac-dyeing process (Hale wood, lathe turning, natural lac from Laccifer lacca, non-toxic pigments)
- GI (Geographical Indication) tags and their importance
- Artisan stories and their workshops
- How to identify authentic vs counterfeit toys
- Child safety of lac-dyed toys
- Sustainability and eco-friendliness
- Supporting artisan livelihoods

Keep responses warm, educational, and concise (2–4 sentences). Use occasional relevant emojis. Speak proudly of Karnataka's craft heritage. If asked about a toy ID, remind them to use the Verify tab. Always be encouraging about supporting authentic artisans."""

    // ─── Quick chat prompts ───────────────────────────────────────────────────
    val quickPrompts: List<String> = listOf(
        "What is Channapatna craft?",
        "How is lac dye made?",
        "Safe for children?",
        "What is GI tag?",
        "Spot fake toys"
    )

    val quickPromptFull: List<String> = listOf(
        "What is the Channapatna craft and why is it special?",
        "How is the lac dye made and applied to toys?",
        "Are Channapatna toys safe for children?",
        "What makes a toy GI certified?",
        "How can I tell if a Channapatna toy is authentic?"
    )
}
