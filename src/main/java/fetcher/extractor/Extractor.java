package fetcher.extractor;

import org.json.JSONArray;

public interface Extractor<C, I> {

    C fillContainer(JSONArray jsonArray);

    I assembleElement();
}
