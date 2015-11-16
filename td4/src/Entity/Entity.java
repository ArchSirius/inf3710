package tp4.Entity;
import java.util.*;

public abstract class Entity
{
	protected tp4.Lib.Orm orm;

	public Entity(tp4.Lib.Orm orm_)
	{
		orm = orm_;
	}
}