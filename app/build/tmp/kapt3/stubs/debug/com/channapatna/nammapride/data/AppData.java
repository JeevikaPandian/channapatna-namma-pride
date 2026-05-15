package com.channapatna.nammapride.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/channapatna/nammapride/data/AppData;", "", "()V", "NAMMABOT_SYSTEM_PROMPT", "", "artisans", "", "Lcom/channapatna/nammapride/model/Artisan;", "getArtisans", "()Ljava/util/List;", "processSteps", "Lcom/channapatna/nammapride/model/ProcessStep;", "getProcessSteps", "quickPromptFull", "getQuickPromptFull", "quickPrompts", "getQuickPrompts", "toyDatabase", "", "Lcom/channapatna/nammapride/model/ToyVerification;", "getToyDatabase", "()Ljava/util/Map;", "toys", "Lcom/channapatna/nammapride/model/Toy;", "getToys", "workshops", "Lcom/channapatna/nammapride/model/Workshop;", "getWorkshops", "app_debug"})
public final class AppData {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, com.channapatna.nammapride.model.ToyVerification> toyDatabase = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.channapatna.nammapride.model.Toy> toys = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.channapatna.nammapride.model.Artisan> artisans = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.channapatna.nammapride.model.Workshop> workshops = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.channapatna.nammapride.model.ProcessStep> processSteps = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAMMABOT_SYSTEM_PROMPT = "You are NammaBot, an enthusiastic AI heritage guide for the Channapatna Namma Pride app \u2014 a platform dedicated to authentic Channapatna lacquered wooden toys from Karnataka, India.\n\nYour expertise covers:\n- Channapatna craft history (centuries-old tradition, UNESCO recognition)\n- The lac-dyeing process (Hale wood, lathe turning, natural lac from Laccifer lacca, non-toxic pigments)\n- GI (Geographical Indication) tags and their importance\n- Artisan stories and their workshops\n- How to identify authentic vs counterfeit toys\n- Child safety of lac-dyed toys\n- Sustainability and eco-friendliness\n- Supporting artisan livelihoods\n\nKeep responses warm, educational, and concise (2\u20134 sentences). Use occasional relevant emojis. Speak proudly of Karnataka\'s craft heritage. If asked about a toy ID, remind them to use the Verify tab. Always be encouraging about supporting authentic artisans.";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> quickPrompts = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> quickPromptFull = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.channapatna.nammapride.data.AppData INSTANCE = null;
    
    private AppData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.channapatna.nammapride.model.ToyVerification> getToyDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.channapatna.nammapride.model.Toy> getToys() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.channapatna.nammapride.model.Artisan> getArtisans() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.channapatna.nammapride.model.Workshop> getWorkshops() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.channapatna.nammapride.model.ProcessStep> getProcessSteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getQuickPrompts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getQuickPromptFull() {
        return null;
    }
}