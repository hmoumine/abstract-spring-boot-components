package org.example.codefox.domaintime.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class {@code Interval} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Getter
@Setter
public class Interval {

    private Date dateDebut;

    private Date dateFin;

    public long getRangeMilliseconds() {
        return this.dateFin.getTime() - this.dateDebut.getTime();
    }

    public long getDaysBetween() {
        return TimeUnit.DAYS
                .convert(this.getRangeMilliseconds(), TimeUnit.MILLISECONDS);
    }
}
