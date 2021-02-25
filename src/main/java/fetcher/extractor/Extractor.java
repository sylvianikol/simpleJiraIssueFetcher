package fetcher.extractor;

import org.json.JSONArray;

public interface Extractor<C, E> {

    C fillContainer(JSONArray jsonArray);

    E assembleElement();
}
