package com.channapatna.nammapride.ui.catalogue;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/channapatna/nammapride/ui/catalogue/ToyGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/channapatna/nammapride/ui/catalogue/ToyGridAdapter$ViewHolder;", "toys", "", "Lcom/channapatna/nammapride/model/Toy;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "newToys", "ViewHolder", "app_debug"})
public final class ToyGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.channapatna.nammapride.ui.catalogue.ToyGridAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.channapatna.nammapride.model.Toy> toys;
    
    public ToyGridAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.channapatna.nammapride.model.Toy> toys) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.channapatna.nammapride.ui.catalogue.ToyGridAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.channapatna.nammapride.ui.catalogue.ToyGridAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.channapatna.nammapride.model.Toy> newToys) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/channapatna/nammapride/ui/catalogue/ToyGridAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/channapatna/nammapride/databinding/ItemToyCardBinding;", "(Lcom/channapatna/nammapride/ui/catalogue/ToyGridAdapter;Lcom/channapatna/nammapride/databinding/ItemToyCardBinding;)V", "getBinding", "()Lcom/channapatna/nammapride/databinding/ItemToyCardBinding;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.channapatna.nammapride.databinding.ItemToyCardBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.channapatna.nammapride.databinding.ItemToyCardBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.channapatna.nammapride.databinding.ItemToyCardBinding getBinding() {
            return null;
        }
    }
}