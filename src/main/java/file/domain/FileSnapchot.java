package file.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Drareeg on 09.10.16.
 */
public class FileSnapchot {

    private List<Line> content;

    public FileSnapchot(List<Line> content) {
        this.content = content;
    }

    public Collection<Line> getLines(){
        return Collections.unmodifiableCollection(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileSnapchot that = (FileSnapchot) o;

        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
