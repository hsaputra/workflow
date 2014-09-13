package com.nirmata.workflow.models;

import com.google.common.base.Preconditions;
import io.airlift.units.Duration;
import java.util.concurrent.TimeUnit;

public class RepetitionModel
{
    private final Duration duration;
    private final Type type;
    private final int qty;

    public enum Type
    {
        RELATIVE,
        ABSOLUTE
    }

    public static final int UNLIMITED = -1;

    public static final RepetitionModel ONCE = new RepetitionModel();

    public RepetitionModel(Duration duration, Type type, int qty)
    {
        this.qty = qty;
        this.duration = Preconditions.checkNotNull(duration, "duration cannot be null");
        this.type = Preconditions.checkNotNull(type, "type cannot be null");
    }

    public Duration getDuration()
    {
        return duration;
    }

    public Type getType()
    {
        return type;
    }

    public int getQty()
    {
        return qty;
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        RepetitionModel that = (RepetitionModel)o;

        if ( qty != that.qty )
        {
            return false;
        }
        if ( !duration.equals(that.duration) )
        {
            return false;
        }
        //noinspection RedundantIfStatement
        if ( type != that.type )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = duration.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + qty;
        return result;
    }

    @Override
    public String toString()
    {
        return "RepetitionModel{" +
            "duration=" + duration +
            ", type=" + type +
            ", qty=" + qty +
            '}';
    }

    private RepetitionModel()
    {
        duration = new Duration(0, TimeUnit.MILLISECONDS);
        type = Type.ABSOLUTE;
        qty = 1;
    }
}